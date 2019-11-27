const MilitaryPlane = require('../models/planes/MilitaryPlane'),
    PassengerPlane = require('../models/planes/PassengerPlane'),
    ExperimentalPlane = require('../models/planes/ExperimentalPlane');

const { militaryPlanes, passengerPlanes, experimentalPlanes } = require("../localStorage/planes")

class PlaneCreator {
    getPlanes() {
        return [
            ...this.createSpecificPlanes(MilitaryPlane, militaryPlanes),
            ...this.createSpecificPlanes(PassengerPlane, passengerPlanes),
            ...this.createSpecificPlanes(ExperimentalPlane, experimentalPlanes)
        ]
    }

    createSpecificPlanes(Instance, specificPlanes) {
        return specificPlanes.map(plane => new Instance({ ...plane }))
    }
}

module.exports = PlaneCreator