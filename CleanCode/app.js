const Airport = require('./models/airport/Airport');

const PlaneCreator = require('./services/PlaneCreator');

let planes = PlaneCreator.getPlanes();

let airport = new Airport(planes);
let militaryAirport = new Airport(airport.getMilitaryPlanes());
let passengerAirport = new Airport(airport.getPassengerPlanes());

console.log(`Military airport sorted by max distance: 
    ${airport.print(militaryAirport.sortByMaxDistance())}`);

console.log(`Passenger airport sorted by max speed: 
${airport.print(passengerAirport.sortByMaxSpeed())}`);

console.log(`Plane with max passenger capacity: 
${airport.print(passengerAirport.getPassengerPlaneWithMaxPassengersCapacity())}`);