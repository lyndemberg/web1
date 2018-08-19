package br.edu.ifpb.web1.dao.factory;

import br.edu.ifpb.web1.dao.interfaces.FactoryDao;

public class Factory {

    public static FactoryDao createFactory(){
        return new FactoryBD();
    }

}
