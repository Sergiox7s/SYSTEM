
package Utilidades;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

public class MenuSuperAdm {

    Color gris = new Color(51, 51, 51);
    Color azul = new Color(0, 102, 204);


    public void cambiarBgColor(JComponent componente) {
        componente.setBackground(azul);
    }


    public void rehacerBgColor(JComponent[] componentes) {
        for (JComponent componente : componentes) {
            componente.setBackground(gris);
        }
    }


    public void configureMouseEvents(JComponent componente, JComponent[] componentesMenu) {
        componente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                cambiarBgColor(componente);
                rehacerBgColor(componentesMenu);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                rehacerBgColor(new JComponent[]{componente});
            }
        });
    }
    
}
