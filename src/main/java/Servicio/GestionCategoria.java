/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.DAO.CategoriaDAO;
import Modelo.Entidades.Categoria;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author rpasc
 */
public class GestionCategoria {

    CategoriaDAO categoriaDao;

    public GestionCategoria() {
        categoriaDao = new CategoriaDAO();
    }

    public List<Categoria> listarCategorias() {
        List<Categoria> listaCategorias = categoriaDao.obtenerListaCategorias();
        return listaCategorias;
    }

    public void mostrarCategorias(JComboBox cbCategorias) {

        cbCategorias.addItem(new Categoria(-1, "Seleccione categoría"));

        for (Categoria categoria : listarCategorias()) {
            cbCategorias.addItem(categoria);
        }

        cbCategorias.setSelectedIndex(0);
    }

}
