class AirportAction {
    constructor(airport) {
        this.airport = airport
    }

    sortByMaxDistance() {
        const planes = this.airport.getPlanes();

        return planes.sort((a, b) => a.getMaxFlightDistance() > b.getMaxFlightDistance())
    }

    sortByMaxSpeed() {
        const planes = this.airport.getPlanes();

        return planes.sort((a, b) => a.getMaxSpeed() > b.getMaxSpeed())
    }

    sortByMaxLoadCapacity() {
        const planes = this.airport.getPlanes();

        return planes.sort((a, b) => a.getMinLoadCapacity() > b.getMinLoadCapacity())
    }
}

module.exports = AirportAction