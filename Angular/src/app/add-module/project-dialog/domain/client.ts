export class Client {
    constructor(public name: string, public id: number) {}
  }
export class ClientResponse {
    clients: Client[];
}
