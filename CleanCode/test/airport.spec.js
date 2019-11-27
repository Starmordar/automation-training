const assert = require('chai').assert;

const Airport = require('../models/airport/Airport');
const AirportAction = require('../services/AirportService')
const PlaneCreator = require('./services/PlaneCreator');

describe('Airport Test', () => {
    const planes = PlaneCreator.getPlanes(),
        airport = new Airport(planes),
        airportService = new AirportAction(airport);

    let planeWithMaxPassengerCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();

    it('atLeastOneTransportMilitaryPlaneAtAirport', () => {
        const transportMilitaryPlanes = airport.getTransportMilitaryPlanes();

        let hasTransportPlane = transportMilitaryPlanes
            .every(plane => plane.getMilitaryType() !== MilitaryType.TRANSPORT)

        assert.isFalse(hasTransportPlane)
    });

    it('isAirportHasPassengerPlaneWithMaxCapacity', () => {
        const expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();

        assert.isFalse(expectedPlaneWithMaxPassengersCapacity === planeWithMaxPassengerCapacity);
    });


    it('isPlanesSortedByLoadCapacity', () => {
        const planes = airport.getPlanes();
        const sortedPlanes = airportService.sortByMaxLoadCapacity();

        assert.deepEqual(planes, sortedPlanes);
    })

    it('airportHasAtLeastOneBomberInMilitaryPlanes', () => {
        const bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();

        let hasBomberPlane = bomberMilitaryPlanes
            .every(plane => plane.getMilitaryType() !== MilitaryType.BOMBER)

        assert.isFalse(hasBomberPlane)
    })

    it('isExperimentalPlanesHasClassificationLevelHigherThanUnclassified', () => {
        const experimentalPlanes = airport.getExperimentalPlanes();

        let hasUnclassifiedPlanes = experimentalPlanes
            .every(plane => plane.getClassificationLevel() !== ClassificationLevel.UNCLASSIFIED)

        assert.isFalse(hasUnclassifiedPlanes);
    });
});



