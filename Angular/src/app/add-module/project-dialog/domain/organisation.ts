export class Organisation {
    constructor(public name: string, public id: number) {}
  }
export class OrganisationResponse {
    organisations: Organisation[];
}
