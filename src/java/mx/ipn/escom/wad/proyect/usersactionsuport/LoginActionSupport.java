package mx.ipn.escom.wad.proyect.usersactionsuport;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author evazquez
 */
public class LoginActionSupport extends ActionSupport {
    class Person implements Serializable{
        String name="FASDasdf";
        String apPat="FASD";
    }
    
    // <editor-fold defaultstate="collapsed" desc="properties region">
    private String userName;
    private String password;
    private Person user;
    private String userResponse;
    // </editor-fold>
    
    public String getUserResponse() {
        return userResponse;
    }

    // <editor-fold defaultstate="callapsed" desc="getters and setters region">
    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person User) {
        this.user = User;
    }
    
    
    
    
    // </editor-fold>
    
    public String onJson() throws Exception{
        String a=this.getPassword();
        String u=this.getUserName();
        Gson helper=new Gson();
        user=new Person();
        user.apPat="FASDFASFas";
        user.name="fsadsdfasdf";
        userResponse=helper.toJson(user);
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setStatus(200);
        response.setContentType("application/json");
        return "json";
    }
    public String execute() throws Exception {

        return SUCCESS;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void validate(){
        if(this.getUserName()==null || this.getPassword()==null)
            this.addActionError("Nombre de usuario o contraseña es null");
        if(this.getUserName().length()==0 || this.getPassword().length()==0)
            this.addActionError("El nombre de usuario y la contraseña no deben de ser vacios no debe ser vacío");
    }
    
}
