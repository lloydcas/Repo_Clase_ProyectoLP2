/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.dao;

import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.model.Area;

/**
 *
 * @author CASTILLO RAMOS LLOYD ERWIN || 20142280
 */
public interface AreaDAO {
    ArrayList<Area>listarTodas();
    int insertar(Area area);
    int modificar(Area area);
    int eliminar(int idArea);
    Area listarPorId(int idArea);
}
