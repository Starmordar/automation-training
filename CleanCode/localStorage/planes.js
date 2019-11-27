const MilitaryPlaneType = require('../models/planes/MilitaryPlaneTypes'),
    ExperimentalPlaneType = require('../models/planes/ExperimentalPlaneType'),
    ClassificationPlaneLevel = require('../models/planes/ClassificationPlaneLevel');

const militaryPlanes = [
    {
        name: "B-1B Lancer",
        maxSpeed: 1050,
        maxFlightDistance: 21000,
        maxLoadCapacity: 80000,
        militaryPlaneType: MilitaryPlaneType.BOMBER
    },
    {
        name: "B-2 Spirit",
        maxSpeed: 1030,
        maxFlightDistance: 22000,
        maxLoadCapacity: 70000,
        militaryPlaneType: MilitaryPlaneType.BOMBER
    },
    {
        name: "B-52 Stratofortress",
        maxSpeed: 1000,
        maxFlightDistance: 20000,
        maxLoadCapacity: 80000,
        militaryPlaneType: MilitaryPlaneType.BOMBER
    },
    {
        name: "F-15",
        maxSpeed: 1500,
        maxFlightDistance: 12000,
        maxLoadCapacity: 10000,
        militaryPlaneType: MilitaryPlaneType.FIGHTER
    },
    {
        name: "F-22",
        maxSpeed: 1550,
        maxFlightDistance: 13000,
        maxLoadCapacity: 11000,
        militaryPlaneType: MilitaryPlaneType.FIGHTER
    },
    {
        name: "C-130 Hercules",
        maxSpeed: 650,
        maxFlightDistance: 5000,
        maxLoadCapacity: 110000,
        militaryPlaneType: MilitaryPlaneType.TRANSPORT
    },
]

const passengerPlanes = [
    {
        name: "Boeing-737",
        maxSpeed: 900,
        maxFlightDistance: 12000,
        maxLoadCapacity: 605000,
        passengersCapacity: 164
    },
    {
        name: "Boeing-737-800",
        maxSpeed: 940,
        maxFlightDistance: 12300,
        maxLoadCapacity: 63870,
        passengersCapacity: 192
    },
    {
        name: "Airbus A320",
        maxSpeed: 930,
        maxFlightDistance: 11800,
        maxLoadCapacity: 63870,
        passengersCapacity: 192
    },
    {
        name: "Airbus A330",
        maxSpeed: 990,
        maxFlightDistance: 14800,
        maxLoadCapacity: 80500,
        passengersCapacity: 222
    },
    {
        name: "Boeing-747",
        maxSpeed: 980,
        maxFlightDistance: 16100,
        maxLoadCapacity: 70500,
        passengersCapacity: 242
    },
    {
        name: "Embraer 190",
        maxSpeed: 870,
        maxFlightDistance: 8100,
        maxLoadCapacity: 30800,
        passengersCapacity: 64
    },
    {
        name: "Bombardier CS300",
        maxSpeed: 920,
        maxFlightDistance: 11000,
        maxLoadCapacity: 60700,
        passengersCapacity: 196
    },
    {
        name: "Sukhoi Superjet 100",
        maxSpeed: 870,
        maxFlightDistance: 11500,
        maxLoadCapacity: 50500,
        passengersCapacity: 140
    }
]

const experimentalPlanes = [
    {
        name: "Bell X-14",
        maxSpeed: 277,
        maxFlightDistance: 482,
        maxLoadCapacity: 500,
        type: ExperimentalPlaneType.HIGH_ALTITUDE,
        classificationLevel: ClassificationPlaneLevel.SECRET
    },
    {
        name: "Sukhoi Superjet 100",
        maxSpeed: 560,
        maxFlightDistance: 307,
        maxLoadCapacity: 500,
        passengersCapacity: 140,
        type: ExperimentalPlaneType.VTOL,
        classificationLevel: ClassificationPlaneLevel.TOP_SECRET
    }
]

module.exports = {
    militaryPlanes: militaryPlanes,
    passengerPlanes: passengerPlanes,
    experimentalPlanes: experimentalPlanes
}