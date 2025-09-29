package com.ies9021.snr.controller;

import com.ies9021.snr.Allegation;
import com.ies9021.snr.dto.AllegationDTO;
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

    public List<AllegationDTO> listarAlegacionesDTO() {
        return dao.listarAlegacionesDTO();
    }

    public List<String> listarEntidades() {
        return dao.listarEntidades();
    }

    public Allegation findById(int id) {
        return dao.listarAlegaciones().stream()
                .filter(a -> a.getIdAllegation() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean crearAlegacion(Allegation a) {
        if (a == null || !validarAlegacion(a)) {
            return false;
        }
        return dao.crearAlegacion(a);
    }

    public boolean actualizarAlegacion(Allegation a) {
        if (a == null || !validarAlegacion(a) || a.getIdAllegation() <= 0) {
            return false;
        }
        return dao.actualizarAlegacion(a);
    }

    public boolean eliminarAlegacion(int id) {
        if (id <= 0) {
            return false;
        }
        return dao.eliminarAlegacion(id);
    }

    public boolean validarAlegacion(Allegation a) {
        return a != null
                && a.getIdUserCreate() > 0
                && a.getIdUserUpdate() > 0
                && a.getIdCategory() > 0
                && a.getIdUser() > 0
                && a.getIdEntity() > 0
                && a.getIdClaim() > 0;
    }

    public void mostrarResumen(Allegation a) {
        if (a != null) {
            a.displaySummary();
        }
    }
}
