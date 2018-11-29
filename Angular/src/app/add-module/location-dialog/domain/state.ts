export class State {
    constructor(public name: string, public id: number) {}
}
  export interface StateResponse {
    results: State[];
  }
