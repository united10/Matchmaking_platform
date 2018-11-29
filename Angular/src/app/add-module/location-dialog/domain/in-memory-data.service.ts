import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemDataService implements InMemoryDbService {
  createDb() {
    let states = [
      { id: 1, name: 'andhra pradesh' },
      { id: 2, name: 'arunachal pradesh' },
      { id: 3, name: 'assam' },
      { id: 4, name: 'bihar' },
      { id: 5, name: 'chhattisgarh' },
      { id: 6, name: 'goa' },
      { id: 7, name: 'gujarat' },
      { id: 8, name: 'haryana' },
      { id: 9, name: 'himachal pradesh' },
      { id: 10, name: 'jammu and kashmir' },
      { id: 11, name: 'jharkhand' },
      { id: 12, name: 'karnataka' },
      { id: 13, name: 'kerala' },
      { id: 14, name: 'madhya pradesh' },
      { id: 15, name: 'maharashtra' },
      { id: 16, name: 'manipur' },
      { id: 17, name: 'meghalaya' },
      { id: 18, name: 'mizoram' },
      { id: 19, name: 'nagaland' },
      { id: 20, name: 'odisha' },
      { id: 21, name: 'punjab' },
      { id: 22, name: 'rajasthan' },
      { id: 23, name: 'sikkim' },
      { id: 24, name: 'tamil nadu' },
      { id: 25, name: 'telangana' },
      { id: 26, name: 'tripura' },
      { id: 27, name: 'uttar pradesh' },
      { id: 28, name: 'uttarakhand' },
      { id: 28, name: 'west bengal' }
    ];
    return {states: {
      results: states
    }};
  }
}
