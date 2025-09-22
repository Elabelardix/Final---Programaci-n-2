package com.ies9021.snr.controller;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.dao.AllegationDAO;

import java.util.List;

public class AllegationController {

    private final AllegationDAO dao;

    public AllegationController() {
        this.dao = new AllegationDAO();
    }

    public List<Allegation> listarAlegaciones() {
    return dao.listarAlegaciones();
    }

    public Allegation findById(int id) {
        return dao.listarAlegaciones().stream()
                  .filter(a -> a.getIdAllegation() == id)
                  .findFirst()
                  .orElse(null);
    }

    public boolean crearAlegacion(Allegation a) {
        if (a == null || !a.isValid()) {
            return false;
        }
        return dao.crearAlegacion(a);
    }

    public boolean actualizarAlegacion(Allegation a) {
        if (a == null || !a.isValid() || a.getIdAllegation() <= 0) {
            return false;
        }
        return dao.actualizarAlegacion(a);
    }

    public boolean eliminarAlegacion(int id) {
        if (id <= 0) return false;
        return dao.eliminarAlegacion(id);
    }

    public boolean validarAlegacion(Allegation a) {
        return a != null && a.isValid();
    }

    public void mostrarResumen(Allegation a) {
        if (a != null) {
            a.displaySummary();
        }
    }
}