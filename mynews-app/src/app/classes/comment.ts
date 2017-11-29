import { News } from '../classes/news';
import { User } from '../classes/user';

export class Comment {
    public id: number;
    private likes: number;
    private dislikes: number;
    private date: Date;
    private user: User;
    private news: News;

    constructor(
        private text: string
    ) { }

    public getId(): number{
        return this.id;
    }
}
