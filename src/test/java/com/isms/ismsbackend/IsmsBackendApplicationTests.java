package com.isms.ismsbackend;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.dao.CityDao;
import com.isms.ismsbackend.dao.WorksiteDao;
import com.isms.ismsbackend.entity.City;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.entity.Worksite;
import com.isms.ismsbackend.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IsmsBackendApplicationTests {
    
    @Autowired
    private CityDao cityDao;
    
    @Autowired
    private WorksiteDao worksiteDao;
    
    @Autowired
    private CityService cityService;

    @Test
    void contextLoads() {
    }
    
    @Test
    void getCity(){
//        cityDao.selectAll().forEach(System.out::println);
        ResultVO resultVO = cityService.queryAllCities(1,5);
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

}
