import {Skill} from './skill';

export class Project {
  constructor(private title: string,
            private fromDate: string,
            private toDate: string,
            private projectUrl: string,
            private role: string,
            private technologiesUsed: Skill[],
            private description: string) {
      this.title = title;
      this.fromDate = fromDate;
      this.toDate = toDate;
      this.projectUrl = projectUrl;
      this.role = role;
      this.technologiesUsed = technologiesUsed;
      this.description = description;
  }
}
