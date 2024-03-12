/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package management.user;


/**
 *
 * @author FLOW
 */
public interface User {
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    boolean login();
    void displayMenu();
}
