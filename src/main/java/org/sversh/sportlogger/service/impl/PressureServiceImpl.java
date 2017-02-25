package org.sversh.sportlogger.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sversh.sportlogger.model.dao.api.PressureDao;
import org.sversh.sportlogger.model.domain.Pressure;
import org.sversh.sportlogger.service.api.PressureService;

/**
 * 
 * @author Sergey Vershinin
 *
 */
@Service
public class PressureServiceImpl implements PressureService {

    @Autowired
    private PressureDao pressureDao;

    @Transactional
    public void addPressure(Short sys, Short dias) {
        Pressure entity = new Pressure();
        entity.setDate(new Date());
        entity.setDias(dias);
        entity.setSys(sys);
        pressureDao.save(entity );
    }

}
