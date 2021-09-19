package service.impl;

import service.LogService;

public class LogServiceImpl implements LogService {
    @Override
    public void log(String massage) {
        System.out.println(massage);
    }
}
