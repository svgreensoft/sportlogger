package org.sversh.sportlogger.model.dao;

import org.springframework.stereotype.Repository;
import org.sversh.sportlogger.model.dao.api.PressureDao;
import org.sversh.sportlogger.model.domain.Pressure;

/**
 * 
 * @author Sergey Vershinin
 *
 */
@Repository
public class PressureDaoImpl extends BaseDao<Long, Pressure> implements PressureDao {

    protected PressureDaoImpl() {
        super(Pressure.class);
    }

}
