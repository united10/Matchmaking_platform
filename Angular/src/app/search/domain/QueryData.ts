export class QueryData {
  constructor(private userId: string,
            private query: string,
            private timeStamp: string) {
      this.userId = userId;
      this.query = query;
      this.timeStamp = timeStamp;
  }
}
