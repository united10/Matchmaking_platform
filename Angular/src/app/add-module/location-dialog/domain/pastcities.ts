export class Pastcities {
    constructor(public name: string, public id: number) {}
  }
export class PastCityResponse {
    cities: Pastcities[];
}
