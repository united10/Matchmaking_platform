import { TestBed } from '@angular/core/testing';

import { DownstreamService } from './downstream.service';

describe('DownstreamService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DownstreamService = TestBed.get(DownstreamService);
    expect(service).toBeTruthy();
  });
});
