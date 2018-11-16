import { Relationship } from './relationship';
export class Output {
    constructor(private operationType: string,
        private sourceNode: string,
        private sourceProperty: string,
        private terminalNode: string,
        private terminalProperties: string,
        private relation: Relationship) {
        this.operationType = operationType;
        this.sourceNode = sourceNode;
        this.sourceProperty = sourceProperty;
        this.terminalNode = terminalNode;
        this.terminalProperties = terminalProperties;
        this.relation = relation;
    }
<<<<<<< HEAD

    // operationType: string;
    // sourceNode: string;
    // sourceProperty: string;
    // terminalNode: string;
    // terminalProperties: string;
    // relationShip: Relationship;
=======
>>>>>>> 9e7726043531d9d4e524b8a080637846f68a9cb7
}
