export class Paststate {
    constructor(public name: string, public id: number) {}
}
  export interface PaststateResponse {
    results: Paststate[];
  }
