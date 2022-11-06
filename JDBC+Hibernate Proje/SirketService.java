package com.uniyaz.service;

import com.uniyaz.dao.impl.SirketImpl;
import com.uniyaz.entity.Sirket;

@Service
@Transactional(rollbackFor = Exception.class)
public class SirketService {

    private final SirketImpl SirketImpl;

    public SirketService() {

        SirketImpl = new SirketImpl();
    }

    public Sirket saveSirket(Sirket Sirket) {
        return SirketImpl.addSirket(Sirket);
    }

    public Sirket updateSirket(Sirket Sirket) {
        return SirketImpl.updateSirket(Sirket);
    }

    public Boolean deleteSirket(Long id) {
        return SirketImpl.deleteSirket(id);
    }
}
