const Plane = require('./Plane');

class MilitaryPlane extends Plane {
    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, militaryPlaneType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryPlaneType = militaryPlaneType;
    }

    getMilitaryPlaneType() {
        return this.militaryPlaneType
    }

    setMilitaryPlaneType(militaryPlaneType) {
        this.militaryPlaneType = militaryPlaneType;
        return this
    }
}

module.exports = MilitaryPlane