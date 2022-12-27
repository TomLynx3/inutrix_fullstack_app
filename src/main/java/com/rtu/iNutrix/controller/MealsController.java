package com.rtu.iNutrix.controller;


import com.rtu.iNutrix.models.BaseResponse;
import com.rtu.iNutrix.models.DTO.Meals.DietDTO;
import com.rtu.iNutrix.models.DTO.Meals.DietRequest;
import com.rtu.iNutrix.service.interfaces.DietService;
import com.rtu.iNutrix.service.interfaces.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meals")
public class MealsController {


    private final MealsService _mealsService;

    private  final DietService _dietService;

    @Autowired
    public MealsController(MealsService mealsService,DietService dietService){
        this._mealsService = mealsService;
        this._dietService = dietService;
    }


    @PostMapping("/create-diet")
    public  BaseResponse createDiet(@RequestBody DietRequest req) throws IllegalAccessException {

        BaseResponse res = new BaseResponse();

        res.setResult(_mealsService.createDiet(req.getDays()));
        res.setSuccess(true);

        return res;
    }

    @PostMapping("/save-diet")
    public  BaseResponse saveDiet(@RequestBody DietDTO req)  {

        BaseResponse res = new BaseResponse();

        res.setResult(_mealsService.saveDiet(req));
        res.setSuccess(true);

        return res;
    }

    @GetMapping("/diets")
    public BaseResponse getUserDiets(){
        BaseResponse res = new BaseResponse();

        res.setResult(_dietService.getDietsMetadata());
        res.setSuccess(true);

        return  res;
    }
}
