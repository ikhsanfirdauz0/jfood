package IkhsanFirdauz.jfood.controller;

import IkhsanFirdauz.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Locale;

@RequestMapping("/promo")
@RestController
public class PromoController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code)
    {
        Promo promo = null;
        promo = DatabasePromo.getPromoByCode(code);
        return promo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                          @RequestParam(value="diskon") int diskon,
                          @RequestParam(value="minPrice") int minPrice,
                          @RequestParam(value="active")  boolean active)
    {
        Promo promo = new Promo(DatabasePromo.getLastId() + 1, code, diskon, minPrice, active);
        try {
            DatabasePromo.addPromo(promo);
        } catch (PromoCodeAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return promo;
    }

}