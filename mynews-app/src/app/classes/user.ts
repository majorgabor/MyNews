
export enum Role{
    GUEST, USER, ADMIN
}

export class User {
    public id: number;
    
    
    private date: Date;
    public role: Role;

    public constructor(
        public name: string,
        private email: string,
        private age: number,
        private city: string,
        private password: string
    ) { }
}
