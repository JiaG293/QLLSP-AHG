package com.openjfx.qllspahg.dao.interfaces;

import com.openjfx.qllspahg.entity.PhongBan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public interface InterfacePhongBandao {
    public ObservableList<PhongBan> DSPhongBan = FXCollections.observableArrayList();
    public ObservableList<PhongBan> getAllPhongBan();
}
