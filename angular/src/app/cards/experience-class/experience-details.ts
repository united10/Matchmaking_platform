export class ExperienceDetails {
    constructor(private organisation: string,
        private role: string,
<<<<<<< HEAD
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
=======
        private fromDate: string,
        private fromMonth: string,
        private fromYear: string,
        private toDate: string,
        private toMonth: string,
        private toYear: string) {
        this.organisation = organisation;
        this.role = role;
        this.fromDate = fromDate;
        this.fromMonth = fromMonth;
        this.fromYear = fromYear;
        this.toMonth = toMonth;
>>>>>>> 9e7726043531d9d4e524b8a080637846f68a9cb7
        this.toMonth = toMonth;
        this.toYear = toYear;
    }
}
