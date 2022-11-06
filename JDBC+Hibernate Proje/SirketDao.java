package com.uniyaz.dao;

import com.uniyaz.entity.Sirket;
import java.util.List;

public interface SirketDao {
    public Sirket addSirket(Sirket Sirket);

    public List<Sirket> findAllSirket();

    public Boolean deleteSirket(Long id);

    public Sirket updateSirket(Sirket Sirket);
}
