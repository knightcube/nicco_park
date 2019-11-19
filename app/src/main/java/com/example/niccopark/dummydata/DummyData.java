package com.example.niccopark.dummydata;

import com.example.niccopark.model.Rides;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    private List<Rides> ridesList;
    //    private List<ParkEvents> eventsList;
    //    private List<Attractions> attractionsList;
    private int category;

    public DummyData(){
        this.ridesList = new ArrayList<Rides>();
    }
    public void setCategory(int category) {
        this.category = category;
    }

    public void setRidesList() {
        this.ridesList.clear();
        if(category == 1){
            // Set family rides
            setFamilyRidesList();
        }else if(category == 2){
            // Set kid rides
            setKidRidesList();
        }else{
            // Set thrill rides
            setThrillRidesList();
        }
    }

    private void setFamilyRidesList() {
        ridesList.add(new Rides("Toy Train", "The toy train has eight bogies powered by diesel engine. Listen to rhythmic music and enjoy the sights and sounds while travelling through the Park.","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/toy-train2.jpg?fit=605%2C394&ssl=1",1));
        ridesList.add(new Rides("Family Carousal", "It’s family time! Here you can experience an enjoyable family ride with 64 different sized horses on board that gains speed when the platform rotates. This is the ultimate virtual horse ride! Gallop on!","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/family-carousel.jpg?fit=605%2C394&ssl=1",1));
        ridesList.add(new Rides("Cable Car", "Take a stroll up a hill to experience one of the eight gondolas. Each gondola has space for four. You will travel over Paddle Boat Lake, where you can get a panoramic view of many of the rides and attractions. For all this time, you might just end up feeling like the ruler of the world!","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/cable-car2.jpg?fit=605%2C394&ssl=1",1));
        ridesList.add(new Rides("River Cave", "This is a scary one! One of the most popular rides in the park, it is the first dark ride in India. Fear the unknown as you await your turn in the boat. The paddle wheel churns the water, which propels the boat into the canal. Suddenly, you find yourself inside a cave surrounded by dinosaurs, volcanic eruptions and a forest fire. As the boat takes a bend, a big T-Rex lunges to get you.","https://i2.wp.com/niccoparks.com/wp-content/uploads/formidable/river-cave1.jpg?fit=605%2C394&ssl=1",1));
        ridesList.add(new Rides("Paddle Bot", "Enjoy a family outing or take a break from touring and soak up some sun in your very own paddle boats. Step into one of the forty, four seated boats at the Paddle Boat jetty and take a ride. These streamlined FRP hull shaped boats gives easy maneuverability and control with the accessibility of cycling.\n" +
                "\n","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/lazy_river_ride2.jpg?fit=605%2C394&ssl=1",1));
        ridesList.add(new Rides("Crazy Tea Party Ride", "Thrills take an entirely new meaning with our Crazy Tea Party Ride. Join the madness with your family, this first of its kind ride in India is sure to be everyone’s cup of tea !","https://i1.wp.com/niccoparks.com/wp-content/uploads/formidable/crazy-tea-party-ride.jpg?fit=605%2C394&ssl=1",1));
        ridesList.add(new Rides("Caterpillar", "Have a monkey as your friend on this ride. Don’t believe it? Come and see for yourself.","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/caterpillar.jpg?fit=605%2C394&ssl=1",1));

    }

    private void setKidRidesList() {
        ridesList.add(new Rides("Children's corner", "Kids! Get together with your friends and have a ball at the playground at the corner of the park. Mom and dad can watch from far.","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/children-corner.jpg?fit=605%2C403&ssl=1",2));
        ridesList.add(new Rides("Merry Go Round", "Fun time for all the tiny tots","https://i2.wp.com/niccoparks.com/wp-content/uploads/formidable/merry-go-round2.jpg?fit=605%2C394&ssl=1",2));
        ridesList.add(new Rides("Water Merry Go Round", "Spin into a twirling frenzy of rotating colours. Meant for our tiniest customers who like to boat with their friends.","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/water_merry_go_round.jpg?fit=605%2C394&ssl=1",2));
    }

    private void setThrillRidesList() {
        ridesList.add(new Rides("Skill Diver Ride", "Sky Diver – the Thrill Ride of 80 feet high, colorful and brightly illuminated, the tower looks tall, slim and exciting. It is a 16 seater ride.","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/12/skydrive_ride.jpg?fit=605%2C394&ssl=1",3));
        ridesList.add(new Rides("Bull Ride", "There comes a time in the affairs of a man when he must take the bull by his horns and face the situation.","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/bull_ride.jpg?fit=605%2C394&ssl=1",3));
        ridesList.add(new Rides("Water Coaster", "The first water slide in Eastern India. There are two straight slides as well as a curved one. Bring along a friend on this double tube ride as you hear your screams echo around you in this speed slide that sends you hurling through tight curves and steep drops. Feel the thrill as you zip down 75 metres in just 7 seconds!","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/water-coaster.jpg?fit=605%2C394&ssl=1",3));
        ridesList.add(new Rides("Twist and Turn", "Are you forever lectured by your parents to stand on your own feet? Here’s your chance to dare them to do the same after experiencing this ride. 75 seconds of mind-blowing fun will leave you rolling all over the place!","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/12/twist_turn1.jpg?fit=605%2C396&ssl=1",3));
        ridesList.add(new Rides("Pirate Ship", "Perched on a pivot, the Pirate Ship is like a pendulum. Beware! This might leave you with a churning stomach! You experience a new high with each swing on the ship. Experience a moment in the life of a pirate! Bring along your eye patch for the total experience!","https://i1.wp.com/niccoparks.com/wp-content/uploads/formidable/pirate_ship1.jpg?fit=605%2C344&ssl=1",3));
        ridesList.add(new Rides("Moon Raker", "Like to be over the moon? Here is your chance to go through it! You never know what thrills and chills you might encounter while experiencing this rollicking roller coaster ride.","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/moon-racker.jpg?fit=605%2C403&ssl=1",3));
        ridesList.add(new Rides("Water Chute", "One of the most popular rides in the Park. This ride is for the daredevils who enjoy thrills and chills. An experience to cherish!","https://i0.wp.com/niccoparks.com/wp-content/uploads/formidable/moon-racker.jpg?fit=605%2C403&ssl=1",3));
        ridesList.add(new Rides("Cyclone","The Roller Coaster: The Cyclone is India’s biggest wooden roller coaster with a 750m-long track. This exciting ride has two trains, each consisting of three cars. The loops, turns and drops are enough to make even the bravest of us scream. Hold on for a hair-raising experience!","https://i2.wp.com/niccoparks.com/wp-content/uploads/formidable/cyclone.jpg?fit=605%2C394&ssl=1",3));
    }

    public List<Rides> getRidesList() {
        setRidesList();
        return ridesList;
    }
}
