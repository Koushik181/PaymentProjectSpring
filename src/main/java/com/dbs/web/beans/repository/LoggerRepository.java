package com.dbs.web.beans.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Employee;
import com.dbs.web.beans.Logger;

public interface LoggerRepository  extends CrudRepository<Logger, Integer>{

}
