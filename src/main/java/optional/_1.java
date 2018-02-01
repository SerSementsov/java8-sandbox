package optional;

import shared.annotations.Bad;
import shared.annotations.Good;
import shared.model.Address;
import shared.model.City;
import shared.model.User;
import shared.model.Utils;

import java.util.Optional;


public class _1 {

    private Utils utils;

    @Bad
    public String getCityNameByUser1(User user) {
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String zipCode = address.getZipCode();
                if (zipCode != null) {
                    City city = utils.findCityByZipCode(zipCode);
                    if (city != null) {
                        return city.getName();
                    }
                }
            }
        }
        throw new RuntimeException("couldn't find city name");
    }

    @Good
    public String getCityNameByUser2(User user) {
        return Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getZipCode)
                .map(utils::findCityByZipCode)
                .map(City::getName)
                .orElseThrow(() -> new RuntimeException("couldn't find city name"));
    }
}
