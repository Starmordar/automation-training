const Plane = require('./Plane');

class GangstaPlane extends Plane {
    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}

module.exports = GangstaPlane