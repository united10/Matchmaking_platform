import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemDataService implements InMemoryDbService {
  createDb() {
    let states = [
      { id: 1, name: 'Andhra Pradesh' },
      { id: 2, name: 'Arunachal Pradesh' },
      { id: 3, name: 'Assam' },
      { id: 4, name: 'Bihar' },
      { id: 5, name: 'Chhattisgarh' },
      { id: 6, name: 'Goa' },
      { id: 7, name: 'Gujarat' },
      { id: 8, name: 'Haryana' },
      { id: 9, name: 'Himachal Pradesh' },
      { id: 10, name: 'Jammu and Kashmir' },
      { id: 11, name: 'Jharkhand' },
      { id: 12, name: 'Karnataka' },
      { id: 13, name: 'Kerala' },
      { id: 14, name: 'Madhya Pradesh' },
      { id: 15, name: 'Maharashtra' },
      { id: 16, name: 'Manipur' },
      { id: 17, name: 'Meghalaya' },
      { id: 18, name: 'Mizoram' },
      { id: 19, name: 'Nagaland' },
      { id: 20, name: 'Odisha' },
      { id: 21, name: 'Punjab' },
      { id: 22, name: 'Rajasthan' },
      { id: 23, name: 'Sikkim' },
      { id: 24, name: 'Tamil Nadu' },
      { id: 25, name: 'Telangana' },
      { id: 26, name: 'Tripura' },
      { id: 27, name: 'Uttar Pradesh' },
      { id: 28, name: 'Uttarakhand' },
      { id: 28, name: 'West Bengal' }
    ];
    return {states: {
      results: states
    }};
  }
}
