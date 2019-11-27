class Plane {
    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    getModel() {
        return this.model
    }

    getMaxSpeed() {
        return this.maxSpeed
    }

    getMaxFlightDistance() {
        return this.maxFlightDistance
    }

    getMinLoadCapacity() {
        return this.maxLoadCapacity
    }

    setModel(model) {
        this.model = model;
        return this
    }

    setMaxSpeed(maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this
    }

    setMaxFlightDistance(maxFlightDistance) {
        this.maxFlightDistance = maxFlightDistance;
        return this
    }

    setMaxLoadCapacity(maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
        return this
    }
}

module.exports = Plane;
