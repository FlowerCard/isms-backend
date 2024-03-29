package com.isms.ismsbackend;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.dao.CityDao;
import com.isms.ismsbackend.dao.MachineDao;
import com.isms.ismsbackend.dao.WorksiteDao;
import com.isms.ismsbackend.entity.*;
import com.isms.ismsbackend.service.CityService;
import com.isms.ismsbackend.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IsmsBackendApplicationTests {
    
    @Autowired
    private CityDao cityDao;
    
    @Autowired
    private WorksiteDao worksiteDao;
    
    @Autowired
    private CityService cityService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private MachineDao machineDao;

    @Test
    void contextLoads() {
        User user = userDao.selectByPrimaryKey(1);
        System.out.println(user);
    }
    
    @Test
    void getCity(){
//        cityDao.selectAll().forEach(System.out::println);
        ResultVO resultVO = cityService.queryAllCities(1,5,"",1);
        PageInfo data = (PageInfo) resultVO.getData();
        System.out.println(data);
        data.getList().forEach(System.out::println);
    }
    
    @Test
    void updateCity() {
        City city = new City();
        city.setCityId(1);
        city.setCityName("上城区");
        city.setIsDelete(0);
        cityService.modifyCity(city);
        ResultVO resultVO = cityService.queryById(city.getCityId());
        System.out.println(resultVO.getData());
    }
    
    @Test
    void getWorksite() {
        PageHelper.startPage(1,3);
        List<Worksite> worksites = worksiteDao.selectByUId(2);
        PageInfo pageInfo = new PageInfo(worksites);
        System.out.println("pageInfo = " + pageInfo);
    }

    @Test
    public void Machine(){
        // machineDao.selectAll(2).forEach(System.out::println);

    }
    
    @Test
    void getMachineByWorkId() {
        System.out.println(machineDao.selectByWorkId(7));
    }
    
    @Test
    void selectBySearch() {
        PageHelper.startPage(1,10);
        List<Worksite> worksiteList = worksiteDao.selectBySearch(2, "", 2);
        PageInfo pageInfo = new PageInfo(worksiteList);
        System.out.println("pageInfo = " + pageInfo);
        pageInfo.getList().forEach(System.out::println);
    }
    
    @Test
    void selectBySearchForCity() {
        ResultVO resultVO = cityService.queryAllCities(1, 10, "", null);
        PageInfo data = (PageInfo) resultVO.getData();
        data.getList().forEach(System.out::println);
    }

}
