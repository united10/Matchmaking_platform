import { Qualification } from "./qualification";
import { Institution } from "./institution";

export class Chicklets {
    constructor(private qualification: Qualification,
        private institution: Institution,
        private summary: string) {
        this.qualification = qualification;
        this.institution = institution;
        this.summary = summary;
    }
}