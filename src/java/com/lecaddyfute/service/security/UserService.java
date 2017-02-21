/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.service.security;


import com.lecaddyfute.model.entities.ParameterDb;
import com.lecaddyfute.model.entities.Role;
import com.lecaddyfute.model.entities.Status;
import com.lecaddyfute.model.entities.Users;

import com.lecaddyfute.model.entities.VisitorCounter;
import com.lecaddyfute.service.DaoService;
import com.lecaddyfute.utils.BasicFonctions;
import com.lecaddyfute.utils.EmailManager;
import com.lecaddyfute.utils.GenericParamName;
import java.util.HashMap;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.stereotype.Service;

/**
 *
 * @author Gervaise Alina
 */
@Service
public class UserService extends DaoService {
   
    public int getStatusIdByName(String name){
        List<Status> status = this.getAll("SELECT s FROM Status s WHERE s.name = '"+ name+"'");
        Status s = status.get(0);
        return s.getId();
    }
    
    public int getRoleIdByName(String name){
        List<Role> roles = this.getAll("SELECT r FROM Role r WHERE r.name = '"+ name+"'");
        Role r = roles.get(0);
        return r.getId();
    }
    public Role getRoleIdByID(int id){
        List<Role> roles = this.getAll("SELECT r FROM Role r WHERE r.id = '"+ id +"'");
        Role r = roles.get(0);
        return r;
    }
    
    public void sendUserSignUpConfirmation(HttpServletRequest request){
        
        String USERNAME = (String)request.getAttribute("username");
        String EMAILTO = (String)request.getAttribute("emailTo");
        String SUBJECT = "Please confirm your email";
        String URL = "http://localhost:8084/lecaddyfute-0.2/email-comfirmation?id="+ request.getAttribute("id")
                      + "&source="+ request.getSession().getId().toLowerCase()
                      + "&username="+USERNAME;
        EmailManager mailer = new EmailManager();
        String message = mailer.parseMessageEmail("newUserConfirmation.html");
        String FACEBOOK_LOGO = mailer.getImagesPath("Facebook-logo.png");
        //FACEBOOK_LOGO = "http://localhost:8084/lecaddyfute-0.2/resources/images/Facebook-logo.png";
        String LOGO = mailer.getImagesPath("favicon.ico");
        //LOGO = "http://localhost:8084/lecaddyfute-0.2/resources/images/favicon.ico";
        message = message.replace("LOGO", LOGO);
        message = message.replace("URL", URL);
        message = message.replace("USERNAME", USERNAME.toUpperCase());
        message = message.replace("FACEBOOK_LOGO", FACEBOOK_LOGO);
        Map <String, String> images = new <String, String> HashMap();
        images.put("FACEBOOK_LOGO", FACEBOOK_LOGO);
        images.put("LOGO", LOGO);
        
        try{
            mailer.sendHtmlEmail(EMAILTO, SUBJECT, message, images);
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
    }
    
    public Map<String, String> getLocalization(HttpServletRequest request){
        Map<String, String> localization = new <String, String>HashMap();
         request.getHeader("VIA");
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        localization.put("ipaddress", ipAddress);
        javaQuery.j2ee.GeoLocation gl = javaQuery.importClass.javaQueryBundle.createGeoLocation();
        //gl.MAPTargetByIP("154.72.166.8", "test");
        gl.MAPTargetByIP(ipAddress, "");
        localization.put("Latitude", gl.Latitude);
        localization.put("Longitude", gl.Longitude);
        localization.put("Country", gl.Country);
        localization.put("City", gl.City);
        localization.put("State", gl.State);
        return localization;
    }
          
    public Users getUserbyUsername(String username){
        Users user = null;
        String query = "select u from Users u  where u.username = '"+ username+"'";
        List<Users> users = this.getAll(query);
        if (!users.isEmpty()){
            user = users.get(0);
        }
        return user;
    }
    public Role getRolebyName(String name){
        Role role = null;
        String query = "select u from Role u  where u.name = '"+ name+"'";
        List<Role> roles = this.getAll(query);
        if (!roles.isEmpty()){
            role = roles.get(0);
        }
        return role;
    }
    public boolean isAdmin(org.springframework.security.core.userdetails.User principal) {
        boolean result = false;
        for (GrantedAuthority ga : principal.getAuthorities()) {
            if (ga.getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Users getUserById(String id) {
        String query = "select u from Users u where u.id='" + id + "'";
        List<Users> l = dao.getAll(query);
        if (!l.isEmpty()) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public int getVisitorsCount(){
        String query0 = "select p from ParameterDb p where p.name='" + GenericParamName.VISITORS_COUNT + "' ";
        List<ParameterDb> parameters = dao.getAll(query0);
        ParameterDb param = parameters.get(0);
        return Integer.valueOf(param.getValue());
    }
    public void countSession(HttpSession session) {
        try {
            String query0 = "select p from ParameterDb p where p.name='" + GenericParamName.VISITORS_COUNT + "' ";
            List<ParameterDb> parameters = dao.getAll(query0);
            ParameterDb param = parameters.get(0);
            Integer nbTotalSession = Integer.valueOf(param.getValue());
            nbTotalSession += 1;
            param.setValue(Integer.toString(nbTotalSession));
            this.update(param);
            if (!session.isNew()){
                return;
            }
            
            
            String currentUserSessionId = session.getAttribute("currentUserSessionId") + "";
            if (!(session.getId()).equals(currentUserSessionId)) {
                session.setAttribute("currentUserSessionId", session.getId());
                String query = "select v from VisitorCounter v where v.anneeVisite='" + BasicFonctions.getCurrentYear() + "' and v.moiVisite='" + BasicFonctions.getCurrentMonth() + "' and v.jourVisite='" + BasicFonctions.getCurrentDayId() + "' and v.heureVisite='" + BasicFonctions.getCurrentHourId() + "'";
                List<VisitorCounter> lSession = dao.getAll(query);
                VisitorCounter vc;
                if (!lSession.isEmpty()) {
                    vc = lSession.get(0);
                    vc.setNbVisite(vc.getNbVisite() + 1);
                    dao.update(vc);
                } else {
                    vc = new VisitorCounter();
                    vc.setAnneeVisite(BasicFonctions.getCurrentYear());
                    vc.setMoiVisite(BasicFonctions.getCurrentMonth());
                    vc.setJourVisite(BasicFonctions.getCurrentDayId());
                    vc.setHeureVisite(BasicFonctions.getCurrentHourId());
                    vc.setNbVisite(1);
                    dao.create(vc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}