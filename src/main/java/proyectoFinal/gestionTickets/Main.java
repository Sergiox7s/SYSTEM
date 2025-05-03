
package proyectoFinal.gestionTickets;

import Modelo.Entidades.Usuario;
import Interfaz.LoginPanel;

public class Main {
    
    public static Usuario usuario;

    public static void main(String[] args) {

        usuario = new Usuario();
        
        LoginPanel login = new LoginPanel();
        login.setVisible(true);
        login.setLocationRelativeTo(null);

    }
}