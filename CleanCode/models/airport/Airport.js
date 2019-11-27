const PassengerPlane = require('../entity/PassengerPlane'),
    MilitaryPlane = require('../entity/MilitaryPlane'),
    ExperimentalPlane = require('../entity/ExperimentalPlane');

const MilitaryPlaneTypes = require('../entity/MilitaryPlaneTypes');

class Airport {
    constructor(planes) {
        this.planes = planes;
    }

    getPlanes() {
        return this.planes
    }

    getListPlanesByType(planeType) {
        return this.planes.filter(plane => plane instanceof planeType)
    }

    getPassengerPlanes() {
        return this.getListPlanesByType(PassengerPlane);
    }

    getMilitaryPlanes() {
        return this.getListPlanesByType(MilitaryPlane);
    }

    getExperimentalPlanes() {
        return this.getListPlanesByType(ExperimentalPlane);
    }

    getPassengerPlaneWithMaxPassengersCapacity() {
        const passengerPlanes = this.getPassengerPlanes();
        let planeWithMaxCapacity = passengerPlanes[0];

        for (const plane of passengerPlanes) {
            if (plane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity())
                planeWithMaxCapacity = Object.assign({}, plane)
        }

        return planeWithMaxCapacity;
    }

    getMilitaryPlanesByType(type) {
        const militaryPlanes = this.getMilitaryPlanes();

        return militaryPlanes.filter(plane => plane.getMilitaryType() === type)
    }

    getTransportMilitaryPlanes() {
        return this.getMilitaryPlanesByType(MilitaryPlaneTypes.TRANSPORT)
    }

    getBomberMilitaryPlanes() {
        return this.getMilitaryPlanesByType(MilitaryPlaneTypes.BOMBER)
    }

    sortByMaxDistance() {
        this.planes.sort((a, b) => (a.Get_Max_Flight_Distance() > b.Get_Max_Flight_Distance()) ? 1 : -1);
        return this;
    }

    sortByMaxSpeed() {
        this.planes.sort((a, b) => (a.getMS() > b.getMS()) ? 1 : -1);
        return this;
    }

    sortByMaxLoadCapacity() {
        this.planes.sort((a, b) => (a.getMinLoadCapacity() > b.getMinLoadCapacity()) ? 1 : -1);
        return this;
    }

    static print(planes) {
        return JSON.stringify(planes);
    }
}

module.exports = Airport;
