export class State {
    constructor(public id: number, public name: string) {}
}
  export interface StateResponse {
    results: State[];
  }
