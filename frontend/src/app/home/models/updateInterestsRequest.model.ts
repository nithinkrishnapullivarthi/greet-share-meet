import { Interest } from './interest.model';

export class UpdateInterestsRequest {
    public is_volunteer: boolean;
    public interests: Interest[];
    public volunteer_interests: Interest[];
}