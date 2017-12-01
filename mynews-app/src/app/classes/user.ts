
export enum Role{
    GUEST, USER, ADMIN
}

export class User {
    private id: number;
    
    private age: number;
    private city: string;
    private date: Date;
    public role: Role;

    public constructor(
        public name: string,
        private email: string,
        private password: string
    ) { }
}
