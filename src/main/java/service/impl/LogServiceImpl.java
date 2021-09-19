package service.impl;

import lib.Component;
import service.LogService;

@Component
public class LogServiceImpl implements LogService {
    @Override
    public void log(String massage) {
        System.out.println(massage);
    }
}
