package com.microservices.learning.service;

import com.microservices.learning.entity.Hotel;
import com.microservices.learning.entity.Rating;
import com.microservices.learning.entity.User;
import com.microservices.learning.exceptions.ResourceNotFoundException;
import com.microservices.learning.external_services.HotelService;
import com.microservices.learning.external_services.RatingServices;
import com.microservices.learning.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired 
    private RatingServices ratingServices;

    @Autowired 
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
            log.info("Starting user save process for: {}", user.getName());
            long startTime = System.currentTimeMillis();

            // generate unique user id
            String randomId = UUID.randomUUID().toString();
            user.setUserId(randomId);

            long beforeDbSave = System.currentTimeMillis();
            User savedUser = this.userRepo.save(user);
            long afterDbSave = System.currentTimeMillis();

            log.info("Database save operation took {} ms", afterDbSave - beforeDbSave);
            log.info("Total user save process took {} ms", afterDbSave - startTime);

            return savedUser;
    }

    @Override
    public List<User> getAllUser() {

            List<User> user = this.userRepo.findAll();

        //     for(int i = 0; i < user.size(); i++){

        //         // implementing RATING Service call 
                
        //         // fetching ratings info of all users

        //         Rating[] infor = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.get(i).getUserId(), Rating[].class);

        //         List<Rating> rating = Arrays.asList(infor);

        //         user.get(i).setRatings(rating);

        //     }

            user.forEach(user1 -> {
                
                Rating[] infor = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user1.getUserId(), Rating[].class);

                List<Rating> ratingsss = Arrays.asList(infor);

                ratingsss.forEach(user2 ->
                    
                    {
                        Hotel aaa = hotelService.hotelInfo(user2.getHotelId());
                        System.out.println("---------------------------");
                        List<Hotel> aba = Arrays.asList(aaa);
                        user
                    }
 
                );

                user1.setRatings(ratingsss);
            });

        return user;
    }

    @Override
    public User getUserById(String userId) {

            User user = this.userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with given id is not found! " + userId)
            );

            // fetching user ratings from RatingService using service discovery

            Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId, Rating[].class);

            List<Rating> ratings = Arrays.asList(ratingOfUser);

            System.out.println("------------------------------------------------------------------");

            if (ratingOfUser != null) {
                for (Rating rating : ratingOfUser) {
                    Hotel HotelInfo = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
                    List<Hotel> hotelInfo = Arrays.asList(HotelInfo);
                    rating.setHotel(hotelInfo);
                }
            }

            System.out.println("------------------------------------------------------------------");
            // log.info("{}", ratingOfUser);
            user.setRatings(ratings);

            return user;
    }

@Override
public User deleteUser(String userId) {
        User user = getUserById(userId);
        this.userRepo.delete(user);
        return user;
}

@Override
public User updateUser(User user) {
        User existingUser = getUserById(user.getUserId());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAbout(user.getAbout());
        return this.userRepo.save(existingUser);
}

}