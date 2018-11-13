export class ExperienceDetails {
    constructor(private organisation: string,
        private role: string,
        private fromDay: number,
        private fromMonth: number,
        private fromYear: number,
        private toDay: number,
        private toMonth: number,
        private toYear: number) {
        this.organisation = organisation;
        this.role = role;
        this.fromDay = fromDay;
        this.fromMonth = fromMonth;
        this.fromYear = fromYear;
        this.toDay = toDay;
        this.toMonth = toMonth;
        this.toYear = toYear;
    }
}
